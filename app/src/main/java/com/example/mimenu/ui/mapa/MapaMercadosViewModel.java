package com.example.mimenu.ui.mapa;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaMercadosViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<MapaActual> mapa = new MutableLiveData<MapaActual>();

    public MapaMercadosViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }

    public LiveData<MapaActual> getMapa(){
        if(mapa==null){
            mapa=new MutableLiveData<>();
        }
        return mapa;
    }

    public void construirMapa(){
        mapa.setValue(new MapaActual());
    }

    protected class MapaActual implements OnMapReadyCallback {
        private GoogleMap mapa;
        private LatLng super1 = new LatLng(-33.30266702538156, -66.33684521758244);
        private LatLng super2 = new LatLng(-33.29672053184221, -66.33899202292177);

        double latitud_media = (super1.latitude + super2.latitude) / 2;
        double longitud_media = (super1.longitude + super2.longitude) / 2;
        private LatLng puntoMedio = new LatLng(latitud_media, longitud_media);

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            googleMap.addMarker(new MarkerOptions().position(super1).title("Carrefour")); //marcador
            googleMap.addMarker(new MarkerOptions().position(super2).title("Vea")); //marcador

            CameraPosition camPos =
                    new CameraPosition.Builder()
                            .target(puntoMedio)
                            .zoom(15)
                            .bearing(0)
                            .tilt(0)
                            .build();

            CameraUpdate update = CameraUpdateFactory.newCameraPosition(camPos);
            googleMap.animateCamera(update);
        }
    }
}