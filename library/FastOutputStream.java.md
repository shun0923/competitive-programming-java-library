---
data:
  _extendedDependsOn: []
  _extendedRequiredBy:
  - icon: ':warning:'
    path: library/FastIO.java
    title: library/FastIO.java
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/FastIO_test.java
    title: library/FastIO_test.java
  - icon: ':heavy_check_mark:'
    path: library/ManyFastIO_test.java
    title: library/ManyFastIO_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 466, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 571, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.io.*;\n\nfinal class FastOutputStream {\n\
    \tprivate static final int BUF_SIZE = 1 << 13;\n\tprivate final byte buf[] = new\
    \ byte[BUF_SIZE];\n\tprivate final OutputStream out;\n\tprivate int count = 0;\n\
    \tprivate static final byte TRUE_BYTES[] = {116, 114, 117, 101};\n\tprivate static\
    \ final byte FALSE_BYTES[] = {102, 97, 108, 115, 101};\n\tprivate static final\
    \ byte INT_MIN_BYTES[] = {45, 50, 49, 52, 55, 52, 56, 51, 54, 52, 56};\n\tprivate\
    \ static final byte LONG_MIN_BYTES[] = {45, 57, 50, 50, 51, 51, 55, 50, 48, 51,\n\
    \t\t\t\t\t\t\t\t\t\t\t\t54, 56, 53, 52, 55, 55, 53, 56, 48, 56};\n\tprivate static\
    \ final int TOKEN_SIZE = 20;\n\tprivate final byte tokenBuf[] = new byte[TOKEN_SIZE];\n\
    \tprivate static final int PRECISION = 16;\n\tpublic FastOutputStream(OutputStream\
    \ out) {\n\t\tthis.out = out;\n\t}\n\tpublic final void print() {  }\n\tpublic\
    \ final void write(final byte b) {\n\t\tif(count == BUF_SIZE) internalFlush();\n\
    \t\tbuf[count ++] = b;\n\t}\n\tpublic final void print(final char c) { write((byte)\
    \ c); }\n\tpublic final void print(final boolean b) {\n\t\tif(b) {\n\t\t\tif(count\
    \ + 4 > BUF_SIZE) internalFlush();\n\t\t\tSystem.arraycopy(TRUE_BYTES, 0, buf,\
    \ count, TRUE_BYTES.length);\n\t\t\tcount += TRUE_BYTES.length;\n\t\t}else {\n\
    \t\t\tif(count + 5 > BUF_SIZE) internalFlush();\n\t\t\tSystem.arraycopy(FALSE_BYTES,\
    \ 0, buf, count, FALSE_BYTES.length);\n\t\t\tcount += FALSE_BYTES.length;\n\t\t\
    }\n\t}\n\tpublic final void print(int x) {\n\t\tif(count + 11 > BUF_SIZE) internalFlush();\n\
    \t\tif(x == Integer.MIN_VALUE) {\n\t\t\tSystem.arraycopy(INT_MIN_BYTES, 0, buf,\
    \ count, INT_MIN_BYTES.length);\n\t\t\tcount += INT_MIN_BYTES.length;\n\t\t\t\
    return;\n\t\t}\n\t\tif(x == 0) {\n\t\t\tbuf[count ++] = 48;\n\t\t\treturn;\n\t\
    \t}\n\t\tif(x < 0) {\n\t\t\tbuf[count ++] = 45;\n\t\t\tx = - x;\n\t\t}\n\t\tint\
    \ tokenCount = 11;\n\t\twhile(x > 0) {\n\t\t\tfinal int y = x / 10;\n\t\t\ttokenBuf[--\
    \ tokenCount] = (byte)(x - (y << 3) - (y << 1) + 48);\n\t\t\tx = y;\n\t\t}\n\t\
    \tSystem.arraycopy(tokenBuf, tokenCount, buf, count, 11 - tokenCount);\n\t\tcount\
    \ += 11 - tokenCount;\n\t}\n\tpublic final void print(long x) {\n\t\tif(count\
    \ + 20 > BUF_SIZE) internalFlush();\n\t\tif(x == Long.MIN_VALUE) {\n\t\t\tSystem.arraycopy(LONG_MIN_BYTES,\
    \ 0, buf, count, LONG_MIN_BYTES.length);\n\t\t\tcount += LONG_MIN_BYTES.length;\n\
    \t\t\treturn;\n\t\t}\n\t\tif(x == 0) {\n\t\t\tbuf[count ++] = 48;\n\t\t\treturn;\n\
    \t\t}\n\t\tif(x < 0) {\n\t\t\tbuf[count ++] = 45;\n\t\t\tx = - x;\n\t\t}\n\t\t\
    int tokenCount = 20;\n\t\twhile(x > 0) {\n\t\t\tfinal long y = x / 10;\n\t\t\t\
    tokenBuf[-- tokenCount] = (byte)(x - (y << 3) - (y << 1) + 48);\n\t\t\tx = y;\n\
    \t\t}\n\t\tSystem.arraycopy(tokenBuf, tokenCount, buf, count, 20 - tokenCount);\n\
    \t\tcount += 20 - tokenCount;\n\t}\n\tpublic final void print(final double d)\
    \ { print(d, PRECISION); }\n\tpublic final void print(double d, final int precision)\
    \ {\n\t\tif(count == BUF_SIZE) internalFlush();\n\t\tif(d < 0) {\n\t\t\tbuf[count\
    \ ++] = 45;\n\t\t\td = - d;\n\t\t}\n\t\td += Math.pow(10, - precision) / 2;\n\t\
    \tprint((long)d);\n\t\tif(precision == 0) return;\n\t\tif(count + precision +\
    \ 1 > BUF_SIZE) internalFlush();\n\t\tbuf[count ++] = 46;\n\t\td -= (long)d;\n\
    \t\tfor(int i = 0; i < precision; i ++) {\n\t\t\td *= 10;\n\t\t\tbuf[count ++]\
    \ = (byte)((int)d + 48);\n\t\t\td -= (int)d;\n\t\t}\n\t}\n\tpublic final void\
    \ print(final String s) { print(s.getBytes()); }\n\tpublic final void print(final\
    \ Object o) { print(o.toString()); }\n\tpublic final void print(final byte[] a)\
    \ {\n\t\tif(count + a.length > BUF_SIZE) internalFlush();\n\t\tif(a.length <=\
    \ BUF_SIZE) {\n\t\t\tSystem.arraycopy(a, 0, buf, count, a.length);\n\t\t\tcount\
    \ += a.length;\n\t\t}else {\n\t\t\ttry { out.write(a, 0, a.length); }catch(IOException\
    \ e) { e.printStackTrace(); }\n\t\t}\n\t}\n\tpublic final void print(final char[]\
    \ a) {\n\t\tbyte b[] = new byte[a.length];\n\t\tfor(int i = 0; i < a.length; i\
    \ ++) b[i] = (byte)a[i];\n\t\tprint(b);\n\t}\n\tpublic final void println() {\
    \ print('\\n'); }\n\tpublic final void println(final char c) { print(c); println();\
    \ }\n\tpublic final void println(final boolean b) { print(b); println(); }\n\t\
    public final void println(final int x) { print(x); println(); }\n\tpublic final\
    \ void println(final long x) { print(x); println(); }\n\tpublic final void println(final\
    \ double d) { print(d); println(); }\n\tpublic final void println(final double\
    \ d, final int precision) { print(d, precision); println(); }\n\tpublic final\
    \ void println(final String s) { print(s); println(); }\n\tpublic final void println(final\
    \ Object o) { print(o); println(); }\n\tpublic final void println(final char[]\
    \ a) { print(a); println(); }\n\tpublic final void println(final int[] a) {\n\t\
    \tfor(int i = 0; i < a.length; i ++) {\n\t\t\tif(i != 0) print(' ');\n\t\t\tprint(a[i]);\n\
    \t\t}\n\t\tprintln();\n\t}\n\tpublic final void println(final long[] a) {\n\t\t\
    for(int i = 0; i < a.length; i ++) {\n\t\t\tif(i != 0) print(' ');\n\t\t\tprint(a[i]);\n\
    \t\t}\n\t\tprintln();\n\t}\n\tpublic final void println(final double[] a) {\n\t\
    \tfor(int i = 0; i < a.length; i ++) {\n\t\t\tif(i != 0) print(' ');\n\t\t\tprint(a[i]);\n\
    \t\t}\n\t\tprintln();\n\t}\n\tpublic final void println(final double[] a, final\
    \ int precision) {\n\t\tfor(int i = 0; i < a.length; i ++) {\n\t\t\tif(i != 0)\
    \ print(' ');\n\t\t\tprint(a[i], precision);\n\t\t}\n\t\tprintln();\n\t}\n\tpublic\
    \ final void println(final String[] a) {\n\t\tfor(int i = 0; i < a.length; i ++)\
    \ {\n\t\t\tif(i != 0) print(' ');\n\t\t\tprint(a[i]);\n\t\t}\n\t\tprintln();\n\
    \t}\n\tpublic final void println(final Object[] a) {\n\t\tfor(int i = 0; i < a.length;\
    \ i ++) {\n\t\t\tif(i != 0) print(' ');\n\t\t\tprint(a[i]);\n\t\t}\n\t\tprintln();\n\
    \t}\n\tprivate final void internalFlush() {\n\t\ttry {\n\t\t\tout.write(buf, 0,\
    \ count);\n\t\t\tcount = 0;\n\t\t}\n\t\tcatch(IOException e) { e.printStackTrace();\
    \ }\n\t}\n\tpublic final void flush() {\n\t\ttry {\n\t\t\tout.write(buf, 0, count);\n\
    \t\t\tout.flush();\n\t\t\tcount = 0;\n\t\t}\n\t\tcatch(IOException e) { e.printStackTrace();\
    \ }\n\t}\n\tpublic final void close() {\n\t\ttry { out.close(); }\n\t\tcatch(IOException\
    \ e) { e.printStackTrace(); }\n\t}\n}"
  dependsOn: []
  isVerificationFile: false
  path: library/FastOutputStream.java
  requiredBy:
  - library/FastIO.java
  timestamp: '2023-03-23 18:53:17+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/ManyFastIO_test.java
  - library/FastIO_test.java
documentation_of: library/FastOutputStream.java
layout: document
redirect_from:
- /library/library/FastOutputStream.java
- /library/library/FastOutputStream.java.html
title: library/FastOutputStream.java
---
