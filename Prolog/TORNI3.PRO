
domains
         s=string*
         s1=s*
predicates
          
          risinat(s1,s1)
          merkis(s1)
          seko(s1,s1)
          novakt(s,s1,s1)
          sablist(s,s1)
          coincidente(s1,s1)
clauses
     risinat(B,B):-merkis(B). 
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
%goal
 %    L=[a,b],T=[s,a,b,d],	
  %   sablist(L,T).
/*     risinat([],Atris),
           write("Atrisinajums:"),nl,
           write("Atris").*/



/*	��蠥� �� ���� ������, � ���ன ����室���
 ��।����� ���� �� ������� ᯨ᮪ ���ᯨ᪮�
 ��㣮�� ᯨ᪠ � ��࠭����� ���浪� ᫥�������
 ������⮢ � ��� ࠧ�뢮�. ��� �襭�� �⮩ �����
 ����室��� �ᯮ�짮���� ��� �।����: sablist
 (���ᯨ᮪) � coincidente(ᮢ�������).

	sablist([X|L],[X|M]):-coincidente(L,M),!.
	sablist(L,[_|M]):-sablist(L,M).
	coincidente([],_).
	coincidente([X|L],[X|M]):-coincidente(L,M).
*/