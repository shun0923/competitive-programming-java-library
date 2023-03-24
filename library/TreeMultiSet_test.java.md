---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/MultiSet.java
    title: library/MultiSet.java
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP2_7_D
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
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ITP2_7_D\n\
    \npackage library;\n\nimport library.Solver;\nimport library.MultiSet;\n\npublic\
    \ class TreeMultiSet_test extends Solver {\n\tpublic static void main(final String[]\
    \ args) { main(args, new TreeMultiSet_test()); }\n\n\tpublic void solve() {\n\t\
    \tTreeMultiSet<Integer> ms = new TreeMultiSet<>();\n\t\tint q = ni();\n\t\tfor(int\
    \ query = 0; query < q; query ++) {\n\t\t\tswitch(ni()) {\n\t\t\tcase 0: ms.add(ni());\
    \ prtln(ms.count()); break;\n\t\t\tcase 1: prtln(ms.count(ni())); break;\n\t\t\
    \tcase 2: int x = ni(); ms.update(x, - ms.count(x)); break;\n\t\t\tcase 3:\n\t\
    \t\t\tInteger l = ni() - 1;\n\t\t\t\tint r = ni();\n\t\t\t\twhile(true) {\n\t\t\
    \t\t\tl = ms.higher(l);\n\t\t\t\t\tif(l == null || l > r) break;\n\t\t\t\t\tlong\
    \ cnt = ms.count(l);\n\t\t\t\t\tfor(int i = 0; i < cnt; i ++) prtln(l);\n\t\t\t\
    \t}\n\t\t\t\tbreak;\n\t\t\t}\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/MultiSet.java
  isVerificationFile: true
  path: library/TreeMultiSet_test.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/TreeMultiSet_test.java
layout: document
redirect_from:
- /verify/library/TreeMultiSet_test.java
- /verify/library/TreeMultiSet_test.java.html
title: library/TreeMultiSet_test.java
---
