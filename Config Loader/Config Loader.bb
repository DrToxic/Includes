If CommandLine$() = "/debug" Then debug = True
;if we're debugging, print the output.
If debug = True Print "LOADING CONFIG"

Width	= 1024
Height	= 768

config = ReadFile("Config.cfg")
If config = 0 Then
	If debug = True Then Print "config not found, using defaults."
Else
	While Not Eof(config)
	temp$ = ReadLine(config)
	
	
	
	Select Upper(Left(temp$,10))
		Case "WIDTH     " Width = Mid$ (temp$,13)
		Case "HEIGHT    " Height = Mid$(temp$,13)
		
		Default If debug = True Print "LOADING CONFIG: Ignored line: "+temp$
	End Select
	Wend
	
	If debug = True Then
		Print "CONFIG LOADED!"
		Print "Width: "+Width
		Print "Height: "+Height
	EndIf
	If debug = True Then Stop
EndIf
;Return Width
;Return Height