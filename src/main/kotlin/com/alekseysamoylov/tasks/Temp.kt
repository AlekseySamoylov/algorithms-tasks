//package com.alekseysamoylov.tasks
//
//
//
//
//
//
//
//
//fun solution(input: Int): String {
//    var number = input
//    var org = number;
//    if(number<=0) {
//        number = -number
//    }// work with absolute values when input is not positive
//    else number--;               // work with one less, if input is positive
//    var left = 0;
//    var right = 1;
//    var moves = [];
//
//
//
//    if(org<=0)
//        while(number!=0){
//            if(number&1)moveLeft();
//            else moveRight();
//            number>>=1;
//        }
//    else
//        while(number!=0){
//            if(number&1)moveRight();
//            else moveLeft();
//            number>>=1;
//        }
//
//    console.log(org, left, right, moves.join(''), (org==left)||(org==right));
//}
//
//for(var i=-20;i<=20;i++)
//findShortestSequence(i);
//}
//
//const moveLeft = () => {
//    moves.push('L');
//    left = 2 * left - right;
//}
//
//const moveRight = () => {
//    moves.push('R');
//    right = 2 * right - left;
//}
