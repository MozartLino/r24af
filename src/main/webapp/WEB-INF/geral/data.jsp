<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="0" cellpadding="0" cellspacing="0">
	<tr valign="top">
		<td>
			<form id="chooseDateForm" action="#">

				<select id="d" class="styledselect-day">
					<option value="">dd</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
				</select>
		</td>
		<td><select id="m" class="styledselect-month">
				<option value="">mm</option>
				<option value="1">Jan</option>
				<option value="2">Feb</option>
				<option value="3">Mar</option>
				<option value="4">Apr</option>
				<option value="5">May</option>
				<option value="6">Jun</option>
				<option value="7">Jul</option>
				<option value="8">Aug</option>
				<option value="9">Sep</option>
				<option value="10">Oct</option>
				<option value="11">Nov</option>
				<option value="12">Dec</option>
		</select></td>
		<td><select id="y" class="styledselect-year">
				<option value="2008">2008</option>
				<option value="2009">2009</option>
				<option value="2010">2010</option>
				<option value="2010">2011</option>
				<option value="2010">2012</option>
				<option value="2010">2013</option>
				<option value="2010">2014</option>
				<option value="2010">2015</option>
				<option value="2010">2016</option>
				<option value="2010">2017</option>
				<option value="2010">2018</option>
				<option value="2010">2019</option>
				<option value="2010">2020</option>
		</select>
			</form></td>
		<td><a href="" id="date-pick"><img alt="" src="<c:url value='/images/forms/icon_calendar.jpg' />"  /></a></td>
	</tr>
</table>