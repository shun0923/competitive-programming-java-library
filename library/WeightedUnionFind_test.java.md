---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/WeightedUnionFind.java
    title: library/WeightedUnionFind.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_1_B
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
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_1_B\n\
    \npackage library;\n\nimport library.Solver;\nimport library.WeightedUnionFind;\n\
    \npublic class WeightedUnionFind_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new WeightedUnionFind_test()); }\n\n\tpublic void\
    \ solve() {\n\t\tint n = ni();\n\t\tint q = ni();\n\t\tWeightedUnionFind uf =\
    \ new WeightedUnionFind(n);\n\t\tfor(int i = 0; i < q; i ++) {\n\t\t\tif(ni()\
    \ == 0) uf.unite(ni(), ni(), nl());\n\t\t\telse {\n\t\t\t\tlong w = uf.diff(ni(),\
    \ ni());\n\t\t\t\tprtln(isINF(w) ? \"?\" : w);\n\t\t\t}\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/WeightedUnionFind.java
  isVerificationFile: true
  path: library/WeightedUnionFind_test.java
  requiredBy: []
  timestamp: '2023-03-25 01:33:47+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/WeightedUnionFind_test.java
layout: document
redirect_from:
- /verify/library/WeightedUnionFind_test.java
- /verify/library/WeightedUnionFind_test.java.html
title: library/WeightedUnionFind_test.java
---
