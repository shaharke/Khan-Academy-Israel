#{if session.username}
	<a href="@{Secure.logout()}" class="login_link">&{'logout.link'}</a>
#{/if} #{else}
	<a href="@{Secure.login()}" class="login_link">&{'login.link'}</a>
#{/else}
