<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>valida data</title>
<script>
	function valData(data) {//dd/mm/aaaa

		day = data.substring(0, 2);
		month = data.substring(3, 5);
		year = data.substring(6, 10);

		if ((month == 01) || (month == 03) || (month == 05) || (month == 07)
				|| (month == 08) || (month == 10) || (month == 12)) {//mes com 31 dias
			if ((day < 01) || (day > 31)) {
				alert('invalid date');
			}
		} else

		if ((month == 04) || (month == 06) || (month == 09) || (month == 11)) {//mes com 30 dias
			if ((day < 01) || (day > 30)) {
				alert('invalid date');
			}
		} else

		if ((month == 02)) {//February and leap year
			if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
				if ((day < 01) || (day > 29)) {
					alert('invalid date');
				}
			} else {
				if ((day < 01) || (day > 28)) {
					alert('invalid date');
				}
			}
		}

	}
</script>
</head>
<body>
	<form>
		<input type="text" name="data" id="data"
			onBlur="return valData(this.value)" />
	</form>
</body>
</html>