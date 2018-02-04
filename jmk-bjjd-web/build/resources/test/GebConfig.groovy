reportsDir = 'build/geb-reports/'
baseUrl = System.getProperty('geb.build.baseUrl','http://localhost:9090/')
driver = { new org.openqa.selenium.htmlunit.HtmlUnitDriver(true) }