predicates
 a b menu pro izp(integer)
database -mans
maja(symbol)
tv(symbol)
clauses
a:-write("Kas ir m�jas 	�pa�nieks ?"),nl,readln(Y),
asserta(maja(Y)).
b:-maja(V),write("M�ja - "),write(V),nl,fail.
b:-menu.
pro:-consult("cc.pro",mans),menu.
izp(1):-write("Kas ir m�jas 	�pa�nieks ?"),nl,
        readln(Y),asserta(maja(Y)),menu.
izp(2):-write("Kas ir televizora �pa�nieks ?"),nl,
        readln(Y),assertz(tv(Y)),menu.
izp(3):-b. 
izp(4):-write("Kas p�rdeva m�ju ?"),nl,
        readln(Y),retract(maja(Y)),menu.       
izp(5):-save("cc.pro",mans).
menu:-
write("1.Papildinasana m�j�m"),nl,
write("2.Papildinasana televizoriem"),nl,
write("3.Piepr. m�j�m"),nl,
write("4.Izsl�g�. m�j�m"),nl,
write("5.Beigt"),nl,readint(K),izp(K).
