<div class="header">
	<div class="header_resize">
		<div class="menu_nav">
			<ul>
				<li><a href="home.jsp"><span><span>Home</span></span></a></li>
				<%if (session.getAttribute("current_user") == null) {%>
				<li><a id="create-user" href="#"><span><span>Register</span></span></a></li>
				<li><a id="sign-in" href="#"><span><span>Sign In</span></span></a></li>
				<%} else {%>
				<li><a id="profile" href="#"><span><span>Profile</span></span></a></li>
				<li><a id="sign-out" href="#"><span><span>Sign Out</span></span></a></li>
				<%}%>
			</ul>
		</div>
		<div class="clr"></div>
	</div>
</div>