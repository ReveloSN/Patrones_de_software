importar org.openqa.selenium.WebDriver;
importar org.openqa.selenium.chrome.ChromeDriver;

clase pública WebDriverSingleton {
    controlador WebDriver estático privado;

    WebDriverSingleton privado() {}

    público estático WebDriver getDriver() {
        si (controlador == null) {
            System.setProperty("webdriver.chrome.driver", "ruta/a/chromedriver");
            controlador = nuevo ChromeDriver();
        }
        conductor de retorno;
    }

    público estático void closeDriver() {
        si (controlador != null) {
            conductor.salir();
            conductor = nulo;
        }
    }
}         