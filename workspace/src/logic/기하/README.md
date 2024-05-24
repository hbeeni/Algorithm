# 기하

> 점, 선, 다각형, 원과 같이 각종 기하학적 도형을 다루는 알고리즘 <br/>
> 실제 코테에서는 대부분 CCW라는 기하학적 성질을 이용해 풀 수 있음

## CCW (Counter-Clockwise)

> 평면상의 3개의 점과 관련된 위치 관계를 판단하는 알고리즘

(x<sub>1</sub>y<sub>2</sub> + x<sub>2</sub>y<sub>3</sub> + x<sub>3</sub>y<sub>1</sub>) -
(x<sub>2</sub>y<sub>1</sub> + x<sub>3</sub>y<sub>2</sub> + x<sub>1</sub>y<sub>3</sub>)

<img src="../../../image/기하_CCW.jpg" width="200px"></img><br/>

- |CCW 결과값| = 세 점의 벡터의 외적값
- |CCW 결과값| / 2 = 세 점으로 이뤄진 삼각형의 넓이

<img src="../../../image/기하_방향에따른CCW결과.jpg" width="400px"></img><br/>
