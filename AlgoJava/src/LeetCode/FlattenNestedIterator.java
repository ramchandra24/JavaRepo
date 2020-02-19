import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> finalList = new ArrayList<>();
    List<NestedInteger> currentList;
    Stack<Integer> indexStack = new Stack<>();
    Stack<List<NestedInteger>> pointerStack = new Stack<>();
    int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        int i = 0;
        indexStack.push(0);
        pointerStack.push(nestedList);
        while (!indexStack.isEmpty()) {
            currentList = pointerStack.pop();
            i = indexStack.pop();
            while (i < currentList.size()) {
                if (currentList.get(i).isInteger() == true) {
                    finalList.add(currentList.get(i).getInteger());
                } else {
                    indexStack.push(i + 1);
                    pointerStack.push(currentList);
                    currentList = currentList.get(i).getList();
                    i = -1;
                }
                ++i;
            }
        }
    }

    @Override
    public Integer next() {
        return (finalList.get(index++));
    }

    @Override
    public boolean hasNext() {
        return (index < finalList.size());
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
 * = i.next();
 */