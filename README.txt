para poner a andar la cosa

java + maven en la pc

tener en el pom las dependencias de selenium y de junit

descargar el chrome driver y colocarlo dentro de alguna carpeta resource del proyecto:
parece que es un ejecutable que se usara en ejecucion para instanciar una pagina de chrome
veo que se usa como una especie de precondicion.
example:
    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",".src/test/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

    }

NOTA IMPORANTE:
Estar super pendiente a que la version de webdriver sea compatible con nuestra version de chrome
en caso de mac, copiarlo en la carpeta oculta usr/local/bin y darle permisos de ejecucion