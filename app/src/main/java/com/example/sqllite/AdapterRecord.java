package com.example.sqllite;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecord extends RecyclerView.Adapter<AdapterRecord.HolderRecord> {

    private Context context;
    private ArrayList<ModelRecord> recordArrayList;
    private ImageButton btnMore;

    public AdapterRecord(Context context, ArrayList<ModelRecord> recordArrayList) {
        this.context = context;
        this.recordArrayList = recordArrayList;
    }

    @NonNull
    @Override
    public HolderRecord onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_record, parent, false);
        return new HolderRecord(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecord holder, int position) {
        ModelRecord modelRecord = recordArrayList.get(position);

        String id = modelRecord.getId();
        String Pelicula = modelRecord.getPelicula();
        String image = modelRecord.getImage();
        String Director = modelRecord.getDirector();
        String Actor = modelRecord.getActor();
        String Duracion = modelRecord.getDuracion();
        String Precio = modelRecord.getPrecio();
        String description = modelRecord.getDescription();

        holder.ivProduct.setImageURI(Uri.parse(image));
        holder.tvPelicula.setText(Pelicula);
        holder.tvPrecio.setText(Precio);

        if (image.equals("null")) {
            holder.ivProduct.setImageResource(R.drawable.ic_launcher_foreground);
        } else {
            holder.ivProduct.setImageURI(Uri.parse(image));
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RecordDetailActivity.class);
                intent.putExtra("RECORD_ID", id);
                context.startActivity(intent);
            }
        });

        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMoreDialog(
                        "" + position,
                        "" + id,
                        "" + Pelicula,
                        "" + image,
                        "" + Director,
                        "" + Actor,
                        "" + Duracion,
                        "" + Precio,
                        "" + description
                );

            }
        });

    }

    private void showMoreDialog(String position, String id, String Pelicula, String image, String Director, String Actor, String Duracion, String Precio, String description) {
        String[] options = {"Editar", "Eliminar"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    Intent intent = new Intent(context, AddUpdate.class);

                    intent.putExtra("ID", id);
                    intent.putExtra("Pelicula", Pelicula);
                    intent.putExtra("IMAGE", image);
                    intent.putExtra("Director", Director);
                    intent.putExtra("Actor", Actor);
                    intent.putExtra("Duracion", Duracion);
                    intent.putExtra("Precio", Precio);
                    intent.putExtra("DESCRIPTION", description);
                    intent.putExtra("isEditMode", true);
                    context.startActivity(intent);

                } else if (which == 1) {

                }
            }
        });
        builder.create().show();
    }


    @Override
    public int getItemCount() {
        return recordArrayList.size();
    }


    class HolderRecord extends RecyclerView.ViewHolder {

        ImageView ivProduct;
        TextView tvPelicula, tvPrecio, tvDescription;
        ImageButton btnMore;


        public HolderRecord(@NonNull View itemView) {
            super(itemView);

            tvPelicula = itemView.findViewById(R.id.tvPelicula);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            btnMore = itemView.findViewById(R.id.btnMore);

        }
    }

}
