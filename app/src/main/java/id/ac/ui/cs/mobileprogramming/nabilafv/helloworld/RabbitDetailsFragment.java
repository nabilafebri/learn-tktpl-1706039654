package id.ac.ui.cs.mobileprogramming.nabilafv.helloworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class RabbitDetailsFragment extends Fragment {

    private RabbitViewModel viewModel;
    private TextView name;
    private ImageView photo;
    private TextView desc;
    private TextView weight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this.getActivity()).get(RabbitViewModel.class);

        viewModel.getSelectedRabbit().observe(this, item -> {
            displayDetails(viewModel.getRabbitDetails(item));
        });
    }

    public void displayDetails(Rabbit rabbit) {
        name.setText(rabbit.getName());
        photo.setImageResource(rabbit.getPhoto());
        desc.setText(rabbit.getDesc());
        weight.setText("Maximum weight: " + rabbit.getWeight());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rabbit_details, container, false);

        name = view.findViewById(R.id.name);
        photo = view.findViewById(R.id.photo);
        desc = view.findViewById(R.id.desc);
        weight = view.findViewById(R.id.weight);

        return view;
    }
}
