---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':x:'
    path: library/WeightedUnionFind.java
    title: library/WeightedUnionFind.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=1330
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=1330\n\
    \npackage library;\n\nimport library.Solver;\nimport library.WeightedUnionFind;\n\
    \npublic class WeightedUnionFind_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new WeightedUnionFind_test()); }\n\n\tpublic void\
    \ solve() {\n\t\twhile(true) {\n\t\t\tint n = ni();\n\t\t\tint q = ni();\n\t\t\
    \tif(n == 0) break;\n\t\t\tWeightedUnionFind uf = new WeightedUnionFind(n);\n\t\
    \t\tfor(int i = 0; i < q; i ++) {\n\t\t\t\tif(nc() == '!') uf.unite(ni() - 1,\
    \ ni() - 1, nl());\n\t\t\t\telse {\n\t\t\t\t\tlong w = uf.diff(ni() - 1, ni()\
    \ - 1);\n\t\t\t\t\tprtln(isINF(w) ? \"UNKNOWN\" : w);\n\t\t\t\t}\n\t\t\t}\n\t\t\
    }\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/WeightedUnionFind.java
  isVerificationFile: true
  path: library/WeightedUnionFind_test.java
  requiredBy: []
  timestamp: '2022-10-03 16:47:29+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/WeightedUnionFind_test.java
layout: document
redirect_from:
- /verify/library/WeightedUnionFind_test.java
- /verify/library/WeightedUnionFind_test.java.html
title: library/WeightedUnionFind_test.java
---
