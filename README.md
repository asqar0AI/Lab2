# Stack and Queue Implementations in Java

This repository contains two stack and two queue implementations in Java using linked lists and array lists.

## MyLinkedListStack

This class implements a stack using a linked list. It has the following methods:

- `push(item)`: adds an element to the top of the stack.
- `pop()`: removes and returns the top element of the stack.
- `peek()`: returns the top element of the stack without removing it.
- `isEmpty()`: returns true if the stack is empty, false otherwise.
- `size()`: returns the number of elements in the stack.

## MyArrayListStack

This class implements a stack using an array list. It has the same methods as MyLinkedListStack.

## MyLinkedListQueue

This class implements a queue using a linked list. It has the following methods:

- `enqueue(item)`: adds an element to the back of the queue.
- `dequeue()`: removes and returns the front element of the queue.
- `peek()`: returns the front element of the queue without removing it.
- `isEmpty()`: returns true if the queue is empty, false otherwise.
- `size()`: returns the number of elements in the queue.

## MyArrayListQueue

This class implements a queue using an array list. It has the same methods as MyLinkedListQueue.

All classes have been implemented using Java Generics, so they can be used with any type of objects.
## MyHashTable

MyHashTable is a Java implementation of a hash table data structure. It provides an efficient way to store and retrieve key-value pairs.

### Features

- Generic implementation that allows keys and values of any comparable type.
- Supports insertion, retrieval, removal, and key/value existence checks.
- Collision handling using separate chaining with linked lists.
- Adjustable capacity to accommodate different load factors.
- Utilizes the hash code of keys to distribute them across the hash table array.

### Usage

1. Create an instance of MyHashTable:

    ```java
    MyHashTable<K, V> hashTable = new MyHashTable<>();
    ```

2. Insert key-value pairs into the hash table using the `put()` method:

    ```java
    hashTable.put(key, value);
    ```

3. Retrieve the value associated with a key using the `get()` method:

    ```java
    V value = hashTable.get(key);
    ```

4. Remove a key-value pair from the hash table using the `remove()` method:

    ```java
    V removedValue = hashTable.remove(key);
    ```

5. Check if a key exists in the hash table using the `containsKey()` method:

    ```java
    boolean containsKey = hashTable.containsKey(key);
    ```

6. Check if a value exists in the hash table using the `containsValue()` method:

    ```java
    boolean containsValue = hashTable.containsValue(value);
    ```

For more details on the implementation and usage, refer to the code and comments in the `MyHashTable.java` file.