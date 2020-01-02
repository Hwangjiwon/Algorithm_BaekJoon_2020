# Algorithm_BackJoon_2020

## **set** ##
----
1. 요소는 중복될 수 없다.
2. 순서가 있을 수있다.
3. 정렬 될 수도 있다.

**HashSet**
빠른 접근 속도 
중복 허용하지 않음
순서 없음

**TreeSet**
중복 허용하지 않음
오름차순 정렬

**LinkedHashSet**
중복 허용하지 않음
삽입 순서에 의해 정렬

----------


## **map** ##
----
key-value 형식으로 데이터를 저장.
key는 중복 불가, value는 중복가능.
put(key,value) : 데이터 저장
get(key) : 데이터 검색
remove(key) : 데이터 삭제

**HashMap**
순서의 저장이 없음.
value에 null값 저장이 가능하다.

**TreeMap**
key를 기준으로 오름차순 정렬.

**LinkedMap**
입력 순서를 기억, 순서 보장

----

## **Next Permutation Algorithm** ##

1. 순열의 전체를 순회하면서(O(n)) N[i] < N[i+1] 인 가장 마지막 i 를 구해낸다.
 <br>1-1. 만약 이때 i가 존재하지 않는다면, 해당 순열이 가장 마지막 순열이 된다.
2. 배열의 끝부터 i 까지 오면서 N[j] > N[i] 인 위치, 즉 N[i] 보다 큰 가장 마지막 Element 를 찾아내고, 이 위치를 J 라고 정한다.
3. N[i] 와 N[j] 를 서로 스왑(Swap)
4. i+1부터 수열의 마지막까지 Reverse 
