function save(){
	f.method="POST";
	f.action="./info_set";
	f.enctype="application/x-www-form-urlencoded";
	f.submit();
}
function cancel(){
	if(confirm("취소 하시겠습니까?")){
		location.reload();
	}
}