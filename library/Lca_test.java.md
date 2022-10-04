---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':heavy_check_mark:'
    path: library/Lca.java
    title: library/Lca.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/lca
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/lca\n\npackage\
    \ library;\n\nimport library.Solver;\nimport library.AbstractGraph;\nimport library.Lca;\n\
    \npublic class Lca_test extends Solver {\n\tpublic static void main(final String[]\
    \ args) { main(args, new Lca_test()); }\n\n\tpublic void solve() {\n\t\tint n\
    \ = ni();\n\t\tint q = ni();\n\t\tArrayUnweightedGraph g = new ArrayUnweightedGraph(n,\
    \ true);\n\t\tfor(int i = 1; i < n; i ++) g.add(ni(), i);\n\t\tLca lca = new Lca(g,\
    \ 0);\n\t\tfor(int i = 0; i < q; i ++) prtln(lca.cal(ni(), ni()));\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/Lca.java
  isVerificationFile: true
  path: library/Lca_test.java
  requiredBy: []
  timestamp: '2022-10-04 18:06:03+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Lca_test.java
layout: document
redirect_from:
- /verify/library/Lca_test.java
- /verify/library/Lca_test.java.html
title: library/Lca_test.java
---
