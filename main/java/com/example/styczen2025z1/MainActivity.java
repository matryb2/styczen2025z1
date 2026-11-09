package com.example.styczen2025z1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import java.util.ArrayList;
import android.widget.Switch;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Zdjecie> wszystkieZdjecia;
    private ZdjeciaAdapter adapter;
    private Switch switchFlower, switchPet, switchCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchFlower = findViewById(R.id.switchKwiaty);
        switchPet = findViewById(R.id.switchZwierzeta);
        switchCar = findViewById(R.id.switchSamochody);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewZdjecia);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        inicjalizujDane();

        adapter = new ZdjeciaAdapter(new ArrayList<>(wszystkieZdjecia));
        recyclerView.setAdapter(adapter);

        switchFlower.setOnCheckedChangeListener((buttonView, isChecked) -> filtrujZdjecia());
        switchPet.setOnCheckedChangeListener((buttonView, isChecked) -> filtrujZdjecia());
        switchCar.setOnCheckedChangeListener((buttonView, isChecked) -> filtrujZdjecia());
    }

    private void inicjalizujDane() {
        wszystkieZdjecia = new ArrayList<>();
        wszystkieZdjecia.add(new Zdjecie(0, "Mak", R.drawable.obraz1, 1, 35));
        wszystkieZdjecia.add(new Zdjecie(1, "Bukiet", R.drawable.obraz2, 1, 43));
        wszystkieZdjecia.add(new Zdjecie(2, "Dalmatyńczyk", R.drawable.obraz3, 2, 2));
        wszystkieZdjecia.add(new Zdjecie(3, "Świnka morska", R.drawable.obraz4, 2, 53));
        wszystkieZdjecia.add(new Zdjecie(4, "Rotwailer", R.drawable.obraz5, 2, 43));
        wszystkieZdjecia.add(new Zdjecie(5, "Audi", R.drawable.obraz6, 3, 11));
        wszystkieZdjecia.add(new Zdjecie(6, "kotki", R.drawable.obraz7, 2, 22));
        wszystkieZdjecia.add(new Zdjecie(7, "Róża", R.drawable.obraz8, 1, 33));
        wszystkieZdjecia.add(new Zdjecie(8, "Świnka morska", R.drawable.obraz9, 2, 123));
        wszystkieZdjecia.add(new Zdjecie(9, "Foksterier", R.drawable.obraz10, 2, 22));
        wszystkieZdjecia.add(new Zdjecie(10, "Szczeniak", R.drawable.obraz11, 2, 12));
        wszystkieZdjecia.add(new Zdjecie(11, "Garbus", R.drawable.obraz12, 3, 321));

    }

    private void filtrujZdjecia() {
        List<Zdjecie> przefiltrowane = new ArrayList<>();

        boolean pokazKwiaty = switchFlower.isChecked();
        boolean pokazZwierzeta = switchPet.isChecked();
        boolean pokazSamochody = switchCar.isChecked();

        for (Zdjecie zdjecie : wszystkieZdjecia) {
            int kat = zdjecie.getCategory();
            if ((kat == 1 && pokazKwiaty) ||
                    (kat == 2 && pokazZwierzeta) ||
                    (kat == 3 && pokazSamochody)) {
                przefiltrowane.add(zdjecie);
            }
        }

        adapter.aktualizujListe(przefiltrowane);
    }
}
