package com.example.styczen2025z1;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ZdjeciaAdapter extends RecyclerView.Adapter<ZdjeciaAdapter.ZdjecieViewHolder> {

    private List<Zdjecie> wyswietlaneZdjecia;

    public ZdjeciaAdapter(List<Zdjecie> wyswietlaneZdjecia) {
        this.wyswietlaneZdjecia = wyswietlaneZdjecia;
    }

    public void aktualizujListe(List<Zdjecie> nowaLista) {
        this.wyswietlaneZdjecia = nowaLista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ZdjecieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_zdjecie, parent, false);
        return new ZdjecieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZdjecieViewHolder holder, int position) {
        Zdjecie aktualneZdjecie = wyswietlaneZdjecia.get(position);

        holder.imageViewZdjecie.setImageResource(aktualneZdjecie.getImageResId());
        holder.imageViewZdjecie.setContentDescription(aktualneZdjecie.getAlt());
        holder.textViewPobrania.setText("Pobrań: " + aktualneZdjecie.getDownloads());

        holder.buttonPobierz.setOnClickListener(v -> {
            aktualneZdjecie.incrementDownloads();
            holder.textViewPobrania.setText("Pobrań: " + aktualneZdjecie.getDownloads());
        });
    }

    @Override
    public int getItemCount() {
        return wyswietlaneZdjecia.size();
    }

    static class ZdjecieViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewZdjecie;
        TextView textViewPobrania;
        Button buttonPobierz;

        public ZdjecieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewZdjecie = itemView.findViewById(R.id.imageViewZdjecie);
            textViewPobrania = itemView.findViewById(R.id.textViewPobrania);
            buttonPobierz = itemView.findViewById(R.id.buttonPobierz);
        }
    }
}