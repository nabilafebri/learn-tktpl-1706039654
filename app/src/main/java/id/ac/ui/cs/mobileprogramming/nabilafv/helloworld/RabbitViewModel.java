package id.ac.ui.cs.mobileprogramming.nabilafv.helloworld;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RabbitViewModel extends ViewModel {

    private final MutableLiveData<String> selectedRabbit = new MutableLiveData<String>();
    private RabbitsRepository repository = new RabbitsRepository();

    public void selectRabbit(String name) {
        selectedRabbit.setValue(name);
    }

    public MutableLiveData<String> getSelectedRabbit() {
        return selectedRabbit;
    }

    public String[] getRabbitList(){
        return repository.getRabbits();
    }

    public Rabbit getRabbitDetails(String name){
        return repository.getRabbitDetails(name);
    }
}
