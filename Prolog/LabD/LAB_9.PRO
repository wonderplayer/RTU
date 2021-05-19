domains
    file = f
    list = symbol*
predicates
    start(string)
    read_file
    test_string(string)
    test_char(symbol)
    member(list,symbol)
database
    delimiters(list)
    delim_counter(integer)
clauses
    delimiters([" ", ",", ".", "!", "?","\10"]).
    delim_counter(0).
    start(Fname) :-
        openread(f, Fname),
        readdevice(f),
        read_file,
        delim_counter(X),
        write("Delimiters: "),
        write(X),
        closefile(f).

    read_file :-
        readln(X),
        concat(X,"\13\10",X_CRLF),
        write(X_CRLF),
        test_string(X_CRLF),
        read_file.

    read_file.

    test_string(S) :-
        %str_len(S,X),
        %write(X),
        frontstr(1,S,C,S1),
        test_char(C),
        test_string(S1).
    test_string(_).

    test_char(C) :-
        delimiters(L),
        member(L,C),
        delim_counter(X),
        %write("Counter: "),
        %write(X),
        X1 = X + 1,
        retractall(delim_counter(_)),
        %write("Retracted"),
        assert(delim_counter(X1)).
        %write("Asserted").
    test_char(_).

    member([H|_],H).
    member([_|T],X) :- member(T,X).
goal
    write("File name -> "),    nl,    nl,    readln(Fname),   start(Fname), retractall(delim_counter(_)), assert(delim_counter(0)).
