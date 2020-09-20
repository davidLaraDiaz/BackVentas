package com.prueba.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.123445678";
	
	public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\n" + 
			"MIIEpAIBAAKCAQEAyfj6iVwVZPdZZ+zBY565DsZKSia2HF++lhY24sGL7kwAkP9x\n" + 
			"gWSNkLNef/xAbmemTL3hdYQIixx3r+6WM4LlTUM4r35fHQ5brC/Cn5Nlkyjigx30\n" + 
			"B6hzo2lkMkq7DBxPXOavoTOaD6B9sPCezSRxgDFTzK2Z4KXAMk2OAnBDmYJyicxz\n" + 
			"nG/AXkanpU8nMHbh4cbAPRk+NImLn9ZPC8dLv77l+cRBwGz7jJ1+67Eirv3BtqZ5\n" + 
			"YuGyO3/3Xmxk4UC0/XdFCJAZv6dUDR2p0vpgAKw6XRS0/Qqk2bD/XqNmYkqOof8G\n" + 
			"/aMrJ/O4iy8mVzndnZcLfK5ozeHtZNeq1KkuVQIDAQABAoIBAQC/LU9oyaLuqTsV\n" + 
			"pgMAGvOsSoFzYuUqQm6SfoCBbxbW/1Xh6gk0o0tk1oPyvYD3gGDnbyyEIfA8TTv1\n" + 
			"ae7+3z3RPnnfk8zQIhEgES02Az04aJDP74BX51leKppPCHG46ussUqeX/NItTIrs\n" + 
			"+zY1k/Njlk1uBj0LaZldhA+Ru1YhbKvVNZxnqyvyLHYaLk0zZRUZT/m8t0xoPRlR\n" + 
			"oJbiO6p/B57Ctbe5+Cyrkgiznsczdeq+45rfrvz/k44tS7W5DaLObM1DeEKTEopI\n" + 
			"bh2cr3Wc1MNLY6DB71nnKQ6ax/GJzEo5gzq8/yKVgqtN/EE3wxuXQRmy7+LTKalI\n" + 
			"mkTpoaKZAoGBAOxwHx2XvD5SKVIe+1hrOVDphSvFnoAKhp9lwpbS81FXVsNvhvWI\n" + 
			"V+Zjupa06eC2QvFtkKUj2KL3UH65QgICIcxnorQI/G5iFpb+dbhOQIKFnCqA+Ui9\n" + 
			"egek6VP/vn/vFOPs7tJ8hayByR3yeGC+hifHqgjpEI4xIuxbrY/mzr3vAoGBANqu\n" + 
			"3LJHhgp0zQBSH0BwgBAhYQ37D7TQk/89ceHTHg8UgDYbly1Nd7nvNS1fLns3l6Lc\n" + 
			"6bcD3+V8D0I7/b8zZFq5I/3R9Ad+hoG8LUEg+CdEIkbpB0JDrLnvQ8ModbULoOFU\n" + 
			"e47OLdSIYepuKRhMACHqC4tSM2aavyrShyQdn1v7AoGASHBlqBxoCTQFAusJGOLp\n" + 
			"EZgqO+n1EMeozUdRIgKJl79JjuEpmSpnu+eMMEZHbZiJ1Aw8h8v+wJdDK0A5MAJV\n" + 
			"Npn96GjkZjFZOHPHv2sCKrsiyIbxWU7sB1GIRzsQs4Odg+OAnC6YiezNoIY8SW+2\n" + 
			"DJQIzWgSsW3uhDnmaDNP3jMCgYEAksIzXnndnPrR8VsrmgVmDG06QzWwTrqD+BF2\n" + 
			"cgVK8PfjK2zMwhxxMxkz6OUtvoeKfkQfnTE+ezYMz3iPTFfjC3egjeDvEnB5OGvf\n" + 
			"OwwzPbbeAhS1SGU+b/IA2eI3TG8nYtFdsnLwEugMPlX7wlCO7jOx16gs0rkbflOX\n" + 
			"Wkd/AS0CgYADXA0e75k89PMhgawTHbPyutqgJxQH5elpiu/0uffvDvxU84jrCO+F\n" + 
			"G2GZKPIdg5njCE2Un3zfDt3rBG3rUYwXCrzXp9gWrxXvTeQueGo1prO05615Vvcp\n" + 
			"b9/BXtEqV+QmeIp9L/lebbFbvxzciK0od7RAcMpJVxSx9p/Kw4uUBA==\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLIC  = "-----BEGIN PUBLIC KEY-----\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyfj6iVwVZPdZZ+zBY565\n" + 
			"DsZKSia2HF++lhY24sGL7kwAkP9xgWSNkLNef/xAbmemTL3hdYQIixx3r+6WM4Ll\n" + 
			"TUM4r35fHQ5brC/Cn5Nlkyjigx30B6hzo2lkMkq7DBxPXOavoTOaD6B9sPCezSRx\n" + 
			"gDFTzK2Z4KXAMk2OAnBDmYJyicxznG/AXkanpU8nMHbh4cbAPRk+NImLn9ZPC8dL\n" + 
			"v77l+cRBwGz7jJ1+67Eirv3BtqZ5YuGyO3/3Xmxk4UC0/XdFCJAZv6dUDR2p0vpg\n" + 
			"AKw6XRS0/Qqk2bD/XqNmYkqOof8G/aMrJ/O4iy8mVzndnZcLfK5ozeHtZNeq1Kku\n" + 
			"VQIDAQAB\n" + 
			"-----END PUBLIC KEY-----";
}
