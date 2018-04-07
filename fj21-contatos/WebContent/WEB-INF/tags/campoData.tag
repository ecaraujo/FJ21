<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="id" required="true"%>
<%@ attribute name="data" required="false"%>
<input type="text" id="${id}" name="${id}" value="${data}" onBlur="return valData(this.value)" onkeypress="mascaraData( this, event )" />
<script>
	$("#${id}").datepicker({showOn:"button", 
		                    dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
                            dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
                            dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
                            monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
                            monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
		                    changeMonth: true, 
		                    changeYear: true, 
		                    dateFormat: 'dd/mm/yy', 
		                    buttonImage: "imagens/calendar.png",
		                    buttonImageOnly: true});
	
</script>
