package assignment_5;

// add(Object obj, int index)
// remove(int index)
// get(int index)
// size()
// push() - добавление в конец списка
// pop() - удаляет последний элемент
// shift() - добавление элемента в начало списка
// unshift - удаление из начала списка со сдвигом остальных

// aux: shiftRightByXPositions
// aux: shiftLeftByYPositions


public interface List {

//    void addNodeByIndex(Object object, int index);

    void removeNodeByIndex(int index);
//
    Object getNodeByIndex(int index);
//
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

