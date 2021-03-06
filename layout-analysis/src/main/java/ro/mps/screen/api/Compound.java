package ro.mps.screen.api;

import ro.mps.screen.base.Node;

import java.util.List;

/**
 * Impemented by nodes that have children
 *
 * @author radu
 */
public interface Compound<T extends Node> {

    /**
     * Returns the children list
     *
     * @return
     */
    List<T> getChildren();

    T getChild(int index);

    void removeChildren(List<T> children);

    void removeChild(T child);

    void addChildren(List<T> children);

    void addChild(T child);

    void addChildAtIndex(int index, T child);

    int getIndexOfChildFromChildrenList(T child);
}
