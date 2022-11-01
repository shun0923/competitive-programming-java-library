---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Convolution.java
    title: library/Convolution.java
  - icon: ':x:'
    path: library/Fps.java
    title: library/Fps.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_1_A
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 421, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 526, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP1_1_A\n\
    \npackage library;\n\nimport java.util.*;\nimport library.Solver;\nimport library.Fps;\n\
    import library.Convolution;\n\npublic class Fps_random_test extends Solver {\n\
    \tpublic static void main(final String[] args) { main(args, new Fps_random_test());\
    \ }\n\n\tpublic void solve() {\n\t\tRandom rnd = new Random();\n\t\tFpsOperator\
    \ op = new CnvFpsOperator(Convolution998.cnv);\n\t\tfor(int i = 0; i < 100; i\
    \ ++) {\n\t\t\tcheckMul(op, randomFps(op, rnd, rnd.nextInt(5000)), randomFps(op,\
    \ rnd, rnd.nextInt(5000)));\n\t\t\tcheckInv(op, randomFps(op, rnd, rnd.nextInt(5000)));\n\
    \t\t\tcheckDiv(op, randomFps(op, rnd, rnd.nextInt(5000)), randomFps(op, rnd, rnd.nextInt(5000)));\n\
    \t\t\tcheckPow(op, randomFps(op, rnd, rnd.nextInt(10)), rnd.nextLong());\n\t\t\
    \tcheckExp(op, randomFps(op, rnd, rnd.nextInt(5000)));\n\t\t\tcheckSqrt(op, randomFps(op,\
    \ rnd, rnd.nextInt(5000)));\n\t\t}\n\t\tfor(int i = 0; i < 100; i ++) {\n\t\t\t\
    checkInv(op, randomFps(op, rnd, i));\n\t\t\tfor(int n = - 100; n < 100; n ++)\
    \ checkPow(op, randomFps(op, rnd, i), n);\n\t\t\tcheckExp(op, randomFps(op, rnd,\
    \ i));\n\t\t\tcheckSqrt(op, randomFps(op, rnd, i));\n\t\t\tfor(int j = 0; j <\
    \ 100; j ++) {\n\t\t\t\tcheckMul(op, randomFps(op, rnd, i), randomFps(op, rnd,\
    \ j));\n\t\t\t\tcheckDiv(op, randomFps(op, rnd, i), randomFps(op, rnd, j));\n\t\
    \t\t}\n\t\t}\n\t\tprtln(\"Hello World\");\n\t}\n\tpublic Fps randomFps(FpsOperator\
    \ op, Random rnd, int n) {\n\t\tFps f = new Fps(op, n);\n\t\tfor(int i = 0; i\
    \ < n; i ++) f.set(i, op.md.mod(rnd.nextLong()));\n\t\treturn f;\n\t}\n\tpublic\
    \ void check(Fps f, Fps g) {\n\t\tassertion(f == g || f.equals(g));\n\t}\n\tpublic\
    \ void checkMul(FpsOperator op, Fps f, Fps g) {\n\t\tcheck(op.mul(f, g), op.naiveMul(f,\
    \ g));\n\t}\n\tpublic void checkInv(FpsOperator op, Fps f) {\n\t\tcheck(op.inv(f),\
    \ op.naiveInv(f));\n\t}\n\tpublic void checkDiv(FpsOperator op, Fps f, Fps g)\
    \ {\n\t\tcheck(op.div(f, g), op.naiveDiv(f, g));\n\t}\n\tpublic void checkPow(FpsOperator\
    \ op, Fps f, long n) {\n\t\tcheck(op.pow(f, n), op.naivePow(f, n));\n\t\tcheck(op.pow(f,\
    \ n), op.binaryPow(f, n));\n\t}\n\tpublic void checkExp(FpsOperator op, Fps f)\
    \ {\n\t\tcheck(op.exp(f), op.naiveExp(f));\n\t}\n\tpublic void checkSqrt(FpsOperator\
    \ op, Fps f) {\n\t\tcheck(op.sqrt(f), op.naiveSqrt(f));\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Fps.java
  - library/Convolution.java
  isVerificationFile: true
  path: library/Fps_random_test.java
  requiredBy: []
  timestamp: '2022-11-01 12:07:23+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/Fps_random_test.java
layout: document
redirect_from:
- /verify/library/Fps_random_test.java
- /verify/library/Fps_random_test.java.html
title: library/Fps_random_test.java
---
