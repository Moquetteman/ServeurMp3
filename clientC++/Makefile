ClientCpp: clientIce.o ServeurIceMP3.o
	g++ -I .  clientIce.o ServeurIceMP3.o -o client -lIce -lIceUtil -pthread

clientIce.o: clientIce.cpp ServeurIceMP3.cpp ServeurIceMP3.h
	g++ -I . -c clientIce.cpp

ServeurIceMP3.o: ServeurIceMP3.cpp ServeurIceMP3.h
	g++ -I . -c ServeurIceMP3.cpp

clean:
	rm -rf *.o
