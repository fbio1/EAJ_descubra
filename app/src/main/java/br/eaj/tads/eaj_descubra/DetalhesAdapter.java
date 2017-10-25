package br.eaj.tads.eaj_descubra;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fbio_ on 15/10/2017.
 */

public class DetalhesAdapter extends RecyclerView.Adapter{

    Context context;
    List<Departamentos> listaDepartamentos;

    public DetalhesAdapter(Context c, List<Departamentos> d) {
        this.context = c;
        this.listaDepartamentos = d;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.detalhes_inflater, parent, false);

        DetalhesViewHolder holder = new DetalhesViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DetalhesViewHolder detalhesViewHolder = (DetalhesViewHolder) holder;
        final Departamentos departamentosEscolhido = listaDepartamentos.get(position);
        detalhesViewHolder.nome.setText(departamentosEscolhido.getNome());
//        detalhesViewHolder.descricao.setText(departamentosEscolhido.getDescricao());

    }

    @Override
    public int getItemCount() {
        return listaDepartamentos == null ? 0 : listaDepartamentos.size();
    }

    class DetalhesViewHolder extends RecyclerView.ViewHolder{
        TextView nome;
        TextView descricao;

        public DetalhesViewHolder(View v) {
            super(v);
            this.nome = v.findViewById(R.id.nome);
//            this.descricao = v.findViewById(R.id.descricao);
        }
    }
}
