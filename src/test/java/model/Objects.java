package model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Objects<T> extends ForwardingSet<T> {

    private Set<T> delegate;


    public Objects() {

        this.delegate = new HashSet<T>();
    }

    public Objects(Collection<T> objects)
    {
        this.delegate = new HashSet<T>(objects);
    }

    public Objects(Objects objects) {
        this.delegate = new HashSet<T>(objects.delegate);
    }

    @Override
    protected Set<T> delegate() {
        return delegate;
    }

    public Objects withAdded (T object) {
        Objects objects = new Objects(this);
        objects.add(object);
        return objects;
    }
    public Objects without (T object) {
        Objects objects = new Objects(this);
        objects.remove(object);
        return objects;
    }
}
