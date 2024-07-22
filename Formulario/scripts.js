document.addEventListener('DOMContentLoaded', () => {
    const departments = [
        { label: 'A', options: ['Amazonas', 'Antioquia', 'Arauca', 'Atlántico'] },
        { label: 'B', options: ['Bolivar', 'Boyacá', 'Bucaramanga'] },
        { label: 'C', options: ['Cundinamarca'] },
        { label: 'D', options: ['Cauca', 'Caquetá', 'Casanare', 'Cesar', 'Chocó', 'Córdoba'] },
        { label: 'G', options: ['Guajira', 'Guainía', 'Guaviare'] },
        { label: 'H', options: ['Huila'] },
        { label: 'M', options: ['Magdalena', 'Meta'] },
        { label: 'N', options: ['Nariño', 'Norte de Santander'] },
        { label: 'P', options: ['Putumayo'] },
        { label: 'Q', options: ['Quindío'] },
        { label: 'R', options: ['Risaralda'] },
        { label: 'S', options: ['Sucre', 'San Andrés y Providencia', 'Santander'] },
        { label: 'T', options: ['Tolima'] },
        { label: 'V', options: ['Valle del Cauca', 'Vaupés', 'Vichada'] }
    ];

    const countries = [
        "Afganistán", "Albania", "Alemania", "Andorra", "Angola", "Antigua y Barbuda", "Arabia Saudita", "Argelia",
        "Argentina", "Armenia", "Australia", "Austria", "Azerbaiyán", "Bahamas", "Bangladés", "Barbados", "Baréin",
        "Bélgica", "Belice", "Benín", "Bielorrusia", "Birmania/Myanmar", "Bolivia", "Bosnia y Herzegovina", "Botsuana",
        "Brasil", "Brunéi", "Bulgaria", "Burkina Faso", "Burundi", "Bután", "Cabo Verde", "Camboya", "Camerún",
        "Canadá", "Catar", "Chad", "Chile", "China", "Chipre", "Ciudad del Vaticano", "Colombia", "Comoras",
        "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica",
        "Ecuador", "Egipto", "El Salvador", "Emiratos Árabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "España",
        "Estados Unidos", "Estonia", "Etiopía", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gabón", "Gambia",
        "Georgia", "Ghana", "Granada", "Grecia", "Guatemala", "Guyana", "Guinea", "Guinea ecuatorial", "Guinea-Bisáu",
        "Haití", "Honduras", "Hungría", "India", "Indonesia", "Irak", "Irán", "Irlanda", "Islandia", "Islas Marshall",
        "Islas Salomón", "Israel", "Italia", "Jamaica", "Japón", "Jordania", "Kazajistán", "Kenia", "Kirguistán",
        "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "Líbano", "Liberia", "Libia", "Liechtenstein", "Lituania",
        "Luxemburgo", "Macedonia del Norte", "Madagascar", "Malasia", "Malaui", "Maldivas", "Malí", "Malta", "Marruecos",
        "Mauricio", "Mauritania", "México", "Micronesia", "Moldavia", "Mónaco", "Mongolia", "Montenegro", "Mozambique",
        "Namibia", "Nauru", "Nepal", "Nicaragua", "Níger", "Nigeria", "Noruega", "Nueva Zelanda", "Omán", "Países Bajos",
        "Pakistán", "Palaos", "Panamá", "Papúa Nueva Guinea", "Paraguay", "Perú", "Polonia", "Portugal", "Reino Unido",
        "República Centroafricana", "República Checa", "República del Congo", "República Democrática del Congo",
        "República Dominicana", "Ruanda", "Rumanía", "Rusia", "Samoa", "San Cristóbal y Nieves", "San Marino",
        "San Vicente y las Granadinas", "Santa Lucía", "Santo Tomé y Príncipe", "Senegal", "Serbia", "Seychelles",
        "Sierra Leona", "Singapur", "Siria", "Somalia", "Sri Lanka", "Suazilandia", "Sudáfrica", "Sudán", "Sudán del Sur",
        "Suecia", "Suiza", "Surinam", "Tailandia", "Tanzania", "Tayikistán", "Timor Oriental", "Togo", "Tonga",
        "Trinidad y Tobago", "Túnez", "Turkmenistán", "Turquía", "Tuvalu", "Ucrania", "Uganda", "Uruguay", "Uzbekistán",
        "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Yibuti", "Zambia", "Zimbabue"
    ];

    const depSelect = document.getElementById('dep');
    departments.forEach(group => {
        const optgroup = document.createElement('optgroup');
        optgroup.label = group.label;
        group.options.forEach(option => {
            const opt = document.createElement('option');
            opt.value = option;
            opt.textContent = option;
            optgroup.appendChild(opt);
        });
        depSelect.appendChild(optgroup);
    });

    const paisSelect = document.getElementById('pais');
    countries.forEach(country => {
        const opt = document.createElement('option');
        opt.value = country;
        opt.textContent = country;
        paisSelect.appendChild(opt);
    });
});

const phoneInputField = document.querySelector("#phone");
    const phoneInput = window.intlTelInput(phoneInputField, {
        utilsScript:
            "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/utils.js",
    });
    const info = document.querySelector(".alert-info");

    function process(event) {
        event.preventDefault();

        const phoneNumber = phoneInput.getNumber();

        info.style.display = "";
        info.innerHTML = `Phone number in E.164 format: <strong>${phoneNumber}</strong>`;
    }

    function getIp(callback) {
        fetch('https://ipinfo.io/json?token=<your token>', { headers: { 'Accept': 'application/json' } })
            .then((resp) => resp.json())
            .catch(() => {
                return {
                    country: 'us',
                };
                const phoneInput = window.intlTelInput(phoneInputField, {
                    preferredCountries: ["us", "co", "in", "de"],
                    utilsScript:
                        "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/utils.js",
                });

            })
            .then((resp) => callback(resp.country));
        const phoneInput = window.intlTelInput(phoneInputField, {
            initialCountry: "auto",
            geoIpLookup: getIp,
            utilsScript:
                "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/utils.js",

        });
    }

