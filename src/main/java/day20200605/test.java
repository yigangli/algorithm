package day20200605;

public class test {
    public static <AnyType extends Comparable<? super AnyType>> AnyType findMax(AnyType [] arr){
        int maxIndex = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i].compareTo(arr[maxIndex])>0){
                maxIndex=i;
            }
        }
        return arr[maxIndex];
    }
    static class Person implements Comparable<Person> {
        String name;
        int age;
        Person(){}
        Person(String name,int age){
            this.name=name;
            this.age=age;
        }
        public int compareTo(Person o) {
            return this.age-o.age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main(String[] args) {
        String[] arr = {"4","2","5","1"};
        //Person[] prr = {new Person("zhangsan",13),new Person("lisi",15),new Person("wangwu",11)};
        System.out.println(findMax(arr));

    }
}
