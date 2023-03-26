---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: library/AbstractGrid.java
    title: library/AbstractGrid.java
  - icon: ':x:'
    path: library/GridBfs.java
    title: library/GridBfs.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://atcoder.jp/contests/abc007/tasks/abc007_3
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
  code: "// verification-helper: PROBLEM https://atcoder.jp/contests/abc007/tasks/abc007_3\n\
    \n\npackage library;\n\nimport library.Solver;\nimport library.AbstractGrid;\n\
    import library.GridBfs;\n\npublic class GridBfs_test extends Solver {\n\tpublic\
    \ static void main(final String[] args) { main(args, new GridBfs_test()); }\n\n\
    \tpublic void solve() {\n\t\tint h = ni();\n\t\tint w = ni();\n\t\tBooleanGrids\
    \ g = new BooleanGrids(h, w);\n\t\tBooleanGrid start = g.get(ni() - 1, ni() -\
    \ 1);\n\t\tBooleanGrid goal = g.get(ni() - 1, ni() - 1);\n\t\tboolean b[][] =\
    \ nb(h, w, '#');\n\t\tg.init(b);\n\n\t\tint dist[] = GridBfs.dist(g, start);\n\
    \t\tprtln(dist[goal.i]);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGrid.java
  - library/GridBfs.java
  isVerificationFile: true
  path: library/GridBfs_test.java
  requiredBy: []
  timestamp: '2023-03-26 17:14:27+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/GridBfs_test.java
layout: document
redirect_from:
- /verify/library/GridBfs_test.java
- /verify/library/GridBfs_test.java.html
title: library/GridBfs_test.java
---
