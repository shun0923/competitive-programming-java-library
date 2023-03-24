---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/UnionFind.java
    title: library/UnionFind.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_11_D
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
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_11_D\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.UnionFind;\n\npublic class UnionFind_uniteAll_test extends Solver\
    \ {\n\tpublic static void main(final String[] args) { main(args, new UnionFind_uniteAll_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tint m = ni();\n\t\tvar\
    \ edges = new UnweightedListNode(-1);\n\t\tfor(int i = 0; i < m; i ++) edges.add(ni(),\
    \ ni());\n\t\tUnionFind uf = new UnionFind(n);\n\t\tuf.uniteAll(edges);\n\t\t\
    int q = ni();\n\t\tfor(int i = 0; i < q; i ++) prtln(uf.same(ni(), ni()) ? \"\
    yes\" : \"no\");\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/UnionFind.java
  isVerificationFile: true
  path: library/UnionFind_uniteAll_test.java
  requiredBy: []
  timestamp: '2023-03-25 00:12:54+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/UnionFind_uniteAll_test.java
layout: document
redirect_from:
- /verify/library/UnionFind_uniteAll_test.java
- /verify/library/UnionFind_uniteAll_test.java.html
title: library/UnionFind_uniteAll_test.java
---
