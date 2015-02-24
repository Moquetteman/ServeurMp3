serveur: mainIce.o MP3.o ServeurIceMP3.o
	g++ -I .  mainIce.o MP3.o ServeurIceMP3.o -o serveur -lIce -lIceUtil -pthread -lvlc

mainIce.o: mainIce.cpp ServeurIceMP3.h MP3.hpp
	g++ -I . -c mainIce.cpp

ServeurIceMP3.o: ServeurIceMP3.cpp ServeurIceMP3.h
	g++ -I . -c ServeurIceMP3.cpp

MP3.o: MP3.cpp MP3.hpp
	g++ -I . -c MP3.cpp

clean:
	rm -rf *.o

mrproper: clean
	rm -rf main
