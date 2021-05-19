domains
    coords = x_y(integer,integer,integer,integer)
predicates
    visi_taisnsturi
    visi_kvadrati
database - r
    rect(string,coords)
database - s
    square(string, integer, integer, integer, integer)
clauses
    visi_taisnsturi :- write("RECTANGLES:"),
        nl,
        rect(Nosaukums,x_y(X1,Y1,X2,Y2)),
        write(Nosaukums),
        write(": "),
        write(X1),
        write(" "),
        write(Y1),
        write(" "),
        write(X2),
        write(" "),
        write(Y2),
        write("."),
        nl,
        fail.
    visi_taisnsturi :- true.

    visi_kvadrati :- write("SQUARES:"),
        nl,
        rect(Nosaukums,x_y(X1,Y1,X2,Y2)),
        X2 - X1 = Y2 - Y1,
        assert(square(Nosaukums,X1,Y1,X2,Y2),s),
        write("Name: "),
        write(Nosaukums),
        write("."),
        nl,
        fail.
    visi_kvadrati :- true.

goal
    %assert(rect("R5",x_y(1,2,3,4))), save("test.txt").
    consult("rects.txt", r), visi_taisnsturi, visi_kvadrati, save("squares.txt",s), retractall(_).