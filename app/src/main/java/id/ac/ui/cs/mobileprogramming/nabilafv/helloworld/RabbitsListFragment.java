package id.ac.ui.cs.mobileprogramming.nabilafv.helloworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

public class RabbitsListFragment extends Fragment {

    private RabbitViewModel viewModel;
    private ListView listView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this.getActivity()).get(RabbitViewModel.class);

        listView.setAdapter(new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, viewModel.getRabbitList()));

        listView.setOnItemClickListener((adapter, itemView, pos, id) -> {
            TextView textView = (TextView) itemView;
            viewModel.selectRabbit(textView.getText().toString());

            RabbitDetailsFragment secondFragment = new RabbitDetailsFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.main_activity, secondFragment);
            transaction.addToBackStack(secondFragment.getClass().getName());
            transaction.commit();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rabbits_list, container, false);
        listView = (ListView)view.findViewById(R.id.rabbits_list_view);

        return view;
    }
}
