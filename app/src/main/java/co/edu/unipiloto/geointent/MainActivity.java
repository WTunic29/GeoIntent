package co.edu.unipiloto.geointent;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLocation;
    private Button btnRoute;
    private Button btnMultipleRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLocation = findViewById(R.id.btnLocation);
        btnRoute = findViewById(R.id.btnRoute);
        btnMultipleRoute = findViewById(R.id.btnMultipleRoute);

        btnLocation.setOnClickListener(v -> mostrarUbicacion());
        btnRoute.setOnClickListener(v -> consultarRuta());
        btnMultipleRoute.setOnClickListener(v -> planificarRecorrido());

    }

    // Mostrar una ubicación en Google Maps
    private void mostrarUbicacion() {
        Uri uri = Uri.parse("geo:4.632339710,-74.065350?q=Universidad Piloto de Colombia");
        abrirGoogleMaps(uri);
    }

    // Consultar una ruta entre origen y destino
    private void consultarRuta() {

        Uri uri = Uri.parse(

                "https://www.google.com/maps/dir/?api=1"
                        + "&origin=Universidad+Piloto+de+Colombia"
                        + "&destination=Museo+Nacional+de+Colombia"
                        + "&travelmode=driving"

        );

        abrirGoogleMaps(uri);

    }

    // Planificar un recorrido con varias paradas
    private void planificarRecorrido() {

        Uri uri = Uri.parse(

                "https://www.google.com/maps/dir/?api=1"
                        + "&origin=Universidad+Piloto+de+Colombia"
                        + "&destination=Museo+Nacional+de+Colombia"
                        + "&waypoints=Plaza+de+Bolivar"
                        + "&travelmode=driving"

        );

        abrirGoogleMaps(uri);

    }

    // Metodo general para abrir Google Maps
    private void abrirGoogleMaps(Uri uri) {

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");

        try {

            startActivity(intent);

        } catch (android.content.ActivityNotFoundException e) {

            intent.setPackage(null);

            try {
                startActivity(intent);

            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(this, "No se encontró una aplicación para abrir mapas", Toast.LENGTH_LONG).show();
            }

        }

    }

}