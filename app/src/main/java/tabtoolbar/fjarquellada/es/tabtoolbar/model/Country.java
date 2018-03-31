package tabtoolbar.fjarquellada.es.tabtoolbar.model;

import java.text.MessageFormat;

/**
 * Created by francisco on 31/3/18.
 */

public class Country {

    private String Name;
    private String CountryCode;


    public Country(String name, String countryCode) {
        Name = name;
        CountryCode = countryCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }


    public String getFlagURL() {
        return MessageFormat.format("http://www.geognos.com/api/en/countries/flag/{0}.png",
                this.getCountryCode());
    }

    // Importante!! Sobreescribimos el método toString de nuestra clase POJO Country
    // Para que cuando el Spinner llame internamente cada objeto, use el name para ser mostrado
    // como único valor posible en la lista desplegable
    @Override
    public String toString() {
        return Name;
    }
}
