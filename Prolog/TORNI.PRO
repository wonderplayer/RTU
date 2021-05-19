domains
         s=string*
         s1=s*
predicates
          risinat(s,s)
          risinat(s,s1)
          merkis(s)
          seko(s,s)
          novakt(s,s,s)
          sablist(s,s)
          coincidente(s,s)
clauses
     risinat(B,[B|_]):-merkis(B). 
     risinat(B,[B|Ris1]):-
          seko(B,B1),
          risinat(B1,Ris1).
     merkis(Sit):-sablist([a,b,c],Sit).
     seko(Stabi,[Stabs1,[Augsa1|Stabs2],Parejie]):-
          novakt([Augsa1|Stabs1],Stabi,Stabi1),
          novakt(Stabs2,Stabi1,Parejie),
          nl,write("Stabs1"),write(Stabs1),
          nl,write("Stabs2"),write(Stabs2).
     novakt(X,[X|L],L).
     novakt(X,[Y|L],[Y|L1]):-novakt(L,X,L1).
     
	sablist([X|L],[X|M]):-coincidente(L,M),!.
	sablist(L,[_|M]):-sablist(L,M).
	coincidente([],_).
	coincidente([X|L],[X|M]):-coincidente(L,M).
goal
     L=[a,b],T=[s,a,b,d],	
     sablist(L,T).
/*     risinat([],Atris),
           write("Atrisinajums:"),nl,
           write("Atris").*/



/*	Решаем еще одну задачу, в которой необходимо
 определить является ли некоторый список подсписком
 другого списка с сохранением порядка следования
 элементов и без разрывов. Для решения этой задачи
 необходимо использовать два предиката: sablist
 (подсписок) и coincidente(совпадение).

	sablist([X|L],[X|M]):-coincidente(L,M),!.
	sablist(L,[_|M]):-sablist(L,M).
	coincidente([],_).
	coincidente([X|L],[X|M]):-coincidente(L,M).
*/