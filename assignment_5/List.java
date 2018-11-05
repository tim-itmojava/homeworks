package assignment_5;

// add(Object obj, int index)                                   (done)
// remove(int index)                                            (done)
// get(int index)                                               (done)
// size()                                                       (done)
// push() - добавление в конец списка                           (done)
// pop() - удаляет последний элемент                            (done)
// shift() - добавление элемента в начало списка                        (TODO:)
// unshift - удаление из начала списка со сдвигом остальных     (done)

// aux: shiftRightByXPositions
// aux: shiftLeftByYPositions


public interface List {

    void addNodeByIndex(Object object, int value, int index);

    void removeNodeByIndex(int index);

    Object getNodeByIndex(int index);

    int getListSize();

}

interface Stack {

    void pushNode(Object object, int value);

    void popNode();

}

interface Queue {

//    void shift(Object object);

    void unshift();

}

