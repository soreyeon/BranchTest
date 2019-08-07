/**
 * 
 */

function inputCheck() {
	var writer = document.getElementById('writer');
	if(writer.value.trim().length == 0) {
		alert('작성자를 입력하세요');
		return false;
	}
	
	var title = document.getElementById('title');
	if(title.value == '') {
		alert('제목을 입력하세요');
		return false;
	}
	
	var cont = document.getElementById('cont');
	if(cont.value == '') {
		alert('내용을 입력하세요');
		return false;
	}
	
	return true;
	
}

window.onload = function() {
	//alert('first');

	var frm = document.querySelector('#frmWrite');
	
	frm.addEventListener('submit', function(e) {
		//alert('submit');
		var result = inputCheck();
		//alert(result);
		if(result == false) {
			e.preventDefault();
			e.stopPropagation();
		}
		return result;
	})
}