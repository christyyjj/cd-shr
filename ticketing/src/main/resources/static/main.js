$(function(){
	// 1 --> serving | 0 --> not serving
	var flag = [0, 0, 0, 0];
	// 1 --> online | 0 --> offline
	var online = [1, 1, 1, 1];
		
	function pad(takenNum){
		return String(takenNum).padStart(4, '0');
	}

	function dot2red(id){
		$("#dot" + id).css("background-color", "red");
	}

	function dot2green(id){
		$("#dot" + id).css("background-color", "green");
	}
	
	function disableCounter(id){
		if (flag[id - 1] == 1){
			var num = $("#curr_num_" + id).val();
			alert("Service " + num + " incomplete!"); 
		}
		else{
			$("#curr_num_" + id).html("Offline");
			$("#toggle" + id).val("Go Online");
			$("#dot" + id).css("background-color", "grey");
			$("#counter" + id).css("background-color", "grey");
			online[id - 1] = 0;
		}
	}
	
	function resumeCounter(id){
		$("#curr_num_" + id).css("visibility", "hidden");
		$("#toggle" + id).val("Go Offline");
		dot2green(id);
		$("#counter" + id).css("background-color", "transparent");
		online[id - 1] = 1;
	}
	
	function toggle(id){
		if (online[id - 1] == 1)
			disableCounter(id);
		else
			resumeCounter(id);
	}
	
	function update_nowServing(){ 
		$.ajax({
			type: "GET", 
			url: "/now_serving", 
			success: function(result){ 
				if (result > 0){ // result == 0 indicates empty queue
					var key = pad(result);
					$("#now-serving").html(key); 
					$("#now-serving").css("visibility", "visible"); 
				}
				else {
					$("#now-serving").html(""); 
				}
		}});
	}
	
	function callNext(id){
		if (online[id - 1] != 0 && flag[id - 1] != 1) {
			$.when(update_nowServing()).then(function() {	
				$.ajax({type: "GET", url: "/call_next", 
					success: function(result){	 
						if (result > 0){
							var key = pad(result);
							$("#curr_num_" + id).html(key);
							$("#curr_num_" + id).css("visibility", "visible");
							dot2red(id);
							flag[id - 1] = 1;
						}
						else{
							alert("No tickets in the waiting queue");
						}
					}
				});
			});
		}
	}
	
	function complete(id){
		if (flag[id - 1] == 1){
			$("#curr_num_" + id).html("Thank you");
			dot2green(id);
			flag[id - 1] = 0;
		}
	}
	
	
	$("#take-num").click(function (){
		var takenNum;
		$.when(
			$.ajax({type: "GET", url: "/number", success: function(result){ takenNum = result }})
		).then(function() {
			var key = pad(takenNum);
			alert("Your number: " + key);
			$("#last-number").html(key);
			$("#last-number").css("visibility", "visible");
			update_nowServing();
		});
	});
	
	$("#call1").click(function (){ callNext("1") });
	$("#call2").click(function (){ callNext("2") });
	$("#call3").click(function (){ callNext("3") });
	$("#call4").click(function (){ callNext("4") });
	
	$("#comp1").click(function (){ complete("1") });
	$("#comp2").click(function (){ complete("2") });
	$("#comp3").click(function (){ complete("3") });
	$("#comp4").click(function (){ complete("4") });
	
	$("#toggle1").click(function (){ toggle("1") });
	$("#toggle2").click(function (){ toggle("2") });
	$("#toggle3").click(function (){ toggle("3") });
	$("#toggle4").click(function (){ toggle("4") });
});