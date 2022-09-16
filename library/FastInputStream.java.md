---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: library/ArbitraryMod_test.java
    title: library/ArbitraryMod_test.java
  - icon: ':heavy_check_mark:'
    path: library/FastIO_test.java
    title: library/FastIO_test.java
  - icon: ':question:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  - icon: ':heavy_check_mark:'
    path: library/HelloWorld_test.java
    title: library/HelloWorld_test.java
  - icon: ':heavy_check_mark:'
    path: library/ManyFastIO_test.java
    title: library/ManyFastIO_test.java
  - icon: ':question:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':x:'
    path: library/Mod107_test.java
    title: library/Mod107_test.java
  - icon: ':x:'
    path: library/Mod998_test.java
    title: library/Mod998_test.java
  - icon: ':question:'
    path: library/Util.java
    title: library/Util.java
  _extendedRequiredBy:
  - icon: ':question:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  - icon: ':question:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':question:'
    path: library/Util.java
    title: library/Util.java
  _extendedVerifiedWith:
  - icon: ':x:'
    path: library/ArbitraryMod_test.java
    title: library/ArbitraryMod_test.java
  - icon: ':heavy_check_mark:'
    path: library/FastIO_test.java
    title: library/FastIO_test.java
  - icon: ':heavy_check_mark:'
    path: library/HelloWorld_test.java
    title: library/HelloWorld_test.java
  - icon: ':heavy_check_mark:'
    path: library/ManyFastIO_test.java
    title: library/ManyFastIO_test.java
  - icon: ':x:'
    path: library/Mod107_test.java
    title: library/Mod107_test.java
  - icon: ':x:'
    path: library/Mod998_test.java
    title: library/Mod998_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':question:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/FastInputStream.java\n"
  code: "package library;\n\nimport java.util.*;\nimport java.io.*;\n\nfinal class\
    \ FastInputStream {\n\tprivate static final int BUF_SIZE = 1 << 14;\n\tprivate\
    \ final InputStream in;\n\tprivate final byte buf[] = new byte[BUF_SIZE];\n\t\
    private int pos = 0;\n\tprivate int count = 0;\n\tprivate static final int TOKEN_SIZE\
    \ = 1 << 20;\n\tprivate final byte tokenBuf[] = new byte[TOKEN_SIZE];\n\n\tpublic\
    \ FastInputStream(final InputStream in) {\n\t\tthis.in = in;\n\t}\n\tprivate final\
    \ void readBuf() {\n\t\tpos = 0;\n\t\ttry { count = in.read(buf); }\n\t\tcatch(IOException\
    \ e) { e.printStackTrace(); }\n\t}\n\tprivate final boolean hasNextByte() {\n\t\
    \tif(pos < count) return true;\n\t\treadBuf();\n\t\treturn count > 0;\n\t}\n\t\
    private final byte read() { if(hasNextByte()) return buf[pos ++]; else throw new\
    \ NoSuchElementException(); }\n\tprivate final boolean isPrintableChar(final byte\
    \ c) { return 33 <= c && c <= 126; }\n\tprivate final boolean isNumber(final byte\
    \ c) { return 48 <= c && c <= 57; }\n\tprivate final void skipUnprintable() {\n\
    \t\twhile(true) {\n\t\t\tfor(int i = pos; i < count; i ++) {\n\t\t\t\tif(isPrintableChar(buf[i]))\
    \ { pos = i; return; }\n\t\t\t}\n\t\t\treadBuf();\n\t\t\tif(count <= 0) throw\
    \ new NoSuchElementException();\n\t\t}\n\t}\n\tprivate final boolean readEOL()\
    \ {\n\t\tif(!hasNextByte()) return true;\n\t\tif(buf[pos] == 13) {\n\t\t\tpos\
    \ ++;\n\t\t\tif(hasNextByte() && buf[pos] == 10) pos ++;\n\t\t\treturn true;\n\
    \t\t}\n\t\tif(buf[pos] == 10) {\n\t\t\tpos ++;\n\t\t\treturn true;\n\t\t}\n\t\t\
    return false;\n\t}\n\n\tpublic final char nextChar() {\n\t\tskipUnprintable();\n\
    \t\treturn (char)buf[pos ++];\n\t}\n\tpublic final String next() {\n\t\tskipUnprintable();\n\
    \t\tint tokenCount = 0;\n\t\touter: while(count > 0) {\n\t\t\tfor(int i = pos;\
    \ i < count; i ++) {\n\t\t\t\tfinal byte b = buf[i];\n\t\t\t\tif(!isPrintableChar(b))\
    \ { pos = i; break outer; }\n\t\t\t\ttokenBuf[tokenCount ++] = b;\n\t\t\t}\n\t\
    \t\treadBuf();\n\t\t}\n\t\treturn new String(tokenBuf, 0, tokenCount);\n\t}\n\t\
    public final String nextLine() {\n\t\treadEOL();\n\t\tif(!hasNextByte()) throw\
    \ new NoSuchElementException();\n\t\tint tokenCount = 0;\n\t\twhile(!readEOL())\
    \ tokenBuf[tokenCount ++] = read();\n\t\treturn new String(tokenBuf, 0, tokenCount);\n\
    \t}\n\tpublic final int nextInt() {\n\t\tskipUnprintable();\n\t\tint n = 0;\n\t\
    \tboolean minus = false;\n\t\tif(buf[pos] == 45) {\n\t\t\tminus = true;\n\t\t\t\
    pos ++;\n\t\t\tif(!hasNextByte() || !isNumber(buf[pos])) throw new InputMismatchException();\n\
    \t\t}\n\t\touter: while(count > 0) {\n\t\t\tfor(int i = pos; i < count; i ++)\
    \ {\n\t\t\t\tfinal byte b = buf[i];\n\t\t\t\tif(!isPrintableChar(b)) { pos = i;\
    \ break outer; }\n\t\t\t\tif(!isNumber(b)) throw new InputMismatchException();\n\
    \t\t\t\tif(minus) {\n\t\t\t\t\tif(n < - 214748364) throw new ArithmeticException(\"\
    int overflow\");\n\t\t\t\t\tif(n == - 214748364 && b > 56) throw new ArithmeticException(\"\
    int overflow\");\n\t\t\t\t\tn = (n << 3) + (n << 1) + 48 - b;\n\t\t\t\t}else {\n\
    \t\t\t\t\tif(n > 214748364) throw new ArithmeticException(\"int overflow\");\n\
    \t\t\t\t\tif(n == 214748364 && b >= 56) throw new ArithmeticException(\"int overflow\"\
    );\n\t\t\t\t\tn = (n << 3) + (n << 1) - 48 + b;\n\t\t\t\t}\n\t\t\t}\n\t\t\treadBuf();\n\
    \t\t}\n\t\treturn n;\n\t}\n\tpublic final long nextLong() {\n\t\tskipUnprintable();\n\
    \t\tlong n = 0;\n\t\tboolean minus = false;\n\t\tif(buf[pos] == 45) {\n\t\t\t\
    minus = true;\n\t\t\tpos ++;\n\t\t\tif(!hasNextByte() || !isNumber(buf[pos]))\
    \ throw new InputMismatchException();\n\t\t}\n\t\touter: while(count > 0) {\n\t\
    \t\tfor(int i = pos; i < count; i ++) {\n\t\t\t\tfinal byte b = buf[i];\n\t\t\t\
    \tif(!isPrintableChar(b)) { pos = i; break outer; }\n\t\t\t\tif(!isNumber(b))\
    \ throw new InputMismatchException();\n\t\t\t\tif(minus) {\n\t\t\t\t\tif(n < -\
    \ 922337203685477580l) throw new ArithmeticException(\"long overflow\");\n\t\t\
    \t\t\tif(n == - 922337203685477580l && b > 56) throw new ArithmeticException(\"\
    long overflow\");\n\t\t\t\t\tn = (n << 3) + (n << 1) + 48 - b;\n\t\t\t\t}else\
    \ {\n\t\t\t\t\tif(n > 922337203685477580l) throw new ArithmeticException(\"long\
    \ overflow\");\n\t\t\t\t\tif(n == 922337203685477580l && b >= 56) throw new ArithmeticException(\"\
    long overflow\");\n\t\t\t\t\tn = (n << 3) + (n << 1) - 48 + b;\n\t\t\t\t}\n\t\t\
    \t}\n\t\t\treadBuf();\n\t\t}\n\t\treturn n;\n\t}\n\tpublic final double nextDouble()\
    \ { return Double.parseDouble(next()); }\n\n\tpublic final void close() {\n\t\t\
    try { in.close(); }\n\t\tcatch(IOException e) { e.printStackTrace(); }\n\t}\n}"
  dependsOn:
  - library/HelloWorld_test.java
  - library/ArbitraryMod_test.java
  - library/Util.java
  - library/ManyFastIO_test.java
  - library/Mod998_test.java
  - library/FastIO_test.java
  - library/FastOutputStream.java
  - library/Mod.java
  - library/Mod107_test.java
  isVerificationFile: false
  path: library/FastInputStream.java
  requiredBy:
  - library/Util.java
  - library/FastOutputStream.java
  - library/Mod.java
  timestamp: '2022-09-17 00:18:49+09:00'
  verificationStatus: LIBRARY_SOME_WA
  verifiedWith:
  - library/HelloWorld_test.java
  - library/ArbitraryMod_test.java
  - library/ManyFastIO_test.java
  - library/Mod998_test.java
  - library/FastIO_test.java
  - library/Mod107_test.java
documentation_of: library/FastInputStream.java
layout: document
redirect_from:
- /library/library/FastInputStream.java
- /library/library/FastInputStream.java.html
title: library/FastInputStream.java
---
