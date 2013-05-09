/*
Count down then redirect script
By JavaScript Kit (http://javascriptkit.com)
Over 400+ free scripts here!
 */

//change below target URL to your own
var targetURL = "/elections/"
// change the second to start counting down from
var countdownfrom = 15

var currentsecond = document.redirect.redirect2.value = countdownfrom + 1
function countredirect() {
	if (currentsecond != 1) {
		currentsecond -= 1
		document.redirect.redirect2.value = currentsecond
	} else {
		window.location = targetURL
		return
	}
	setTimeout("countredirect()", 1000)
}

countredirect()