package designpattern.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

interface NeuronLayer extends Iterable<Neuron> {

  default void createLayers(NeuronLayer neurons) {
    for (Neuron thisNeuron : this) {
      for (Neuron otherNeuron : neurons) {
        thisNeuron.getOut().add(otherNeuron);
        otherNeuron.getIn().add(thisNeuron);
      }
    }
  }
}

class Neuron implements NeuronLayer {

  private List<Neuron> in, out;

  public List<Neuron> getIn() {
    return in;
  }

  public void setIn(List<Neuron> in) {
    this.in = in;
  }

  public List<Neuron> getOut() {
    return out;
  }

  public void setOut(List<Neuron> out) {
    this.out = out;
  }

  @Override
  public Iterator<Neuron> iterator() {
    return Collections.singleton(this).iterator();
  }

  @Override
  public void forEach(Consumer<? super Neuron> action) {
    action.accept(this);
  }

  @Override
  public Spliterator<Neuron> spliterator() {
    return Collections.singleton(this).spliterator();
  }
}

class NeuronGroup extends ArrayList<Neuron> implements NeuronLayer {

}

public class Demo2 {

  public static void main(String[] args) {
    Neuron neuron = new Neuron();
    Neuron neuron1 = new Neuron();
    NeuronGroup group = new NeuronGroup();
    NeuronGroup group1 = new NeuronGroup();
    
    neuron.createLayers(neuron1);
    neuron.createLayers(group);
    group1.createLayers(neuron);
    group1.createLayers(group);
  }
}
